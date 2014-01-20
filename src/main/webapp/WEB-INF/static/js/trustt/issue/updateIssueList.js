/**
 * Created by Peter Johnston on 1/14/14.
 */

/**
 * Uses an ajax call to update the assigned user to the correct issue in the issue list
 * Should pop up a menu when clicked to give the user options of available users to assign
 * Should also pop up a save option, which would initiate saving the changes in the database
 */
$(document).ready(function(){
    // Hide all the issue action inputs until the user clicks a button to alter them
    $('.inputIssueType').hide();
    $('.inputIssueStatus').hide();
    $('.inputIssuePriority').hide();
    $('.inputAssignedUserName').hide();

    // Hide the save button until it is needed
    $('#saveIssueChanges').hide();

    // Load all user names for auto complete
    fetchUserNames(function(users) {

        $('.assignUsersButtonMain').click(function() {

            var currentId = this.getAttribute("id");
            var inputNameField = $('#inputAssignedUserName-' + currentId);
            var inputNameButton = $('#inputAssignedUserNameButton-' + currentId);
            var assignButton = $('#' + currentId);
            var updatedDisplayedAssignedUser = $('#assignedUser-' + currentId);

            // When assign User is clicked, show the text box to enter a user
            inputNameField.show(200, function() {
                inputNameField.focus();
            });
            inputNameButton.show(200);
            assignButton.hide();

            // When the user clicks outside of the text box, hide the text box again
            inputNameField.blur(function() {
                assignButton.show(300);
                inputNameField.hide();
                inputNameButton.hide();
            });

            inputNameField.keydown(function(e) {
                var charCode = e.which;
                console.log(charCode);

                var userNamesDict = [];
                for(var i = 0; i < users.length; i++) {
                    userNamesDict.push({ value:users[i] , data:users[i]});
                }
                inputNameField.autocomplete({
                    source: userNamesDict,
                    noResults: ""
                });
                if(charCode == 13) {
                    // Pass along the inputted user information to the server
                    var data = {userInput : inputNameField.val()};
                    ajaxCall(data, updatedDisplayedAssignedUser);
                    $('#saveIssueChanges').show(200);
                }
            });
            return false;
        }); // End of assign user button click
    });
}); // End of ready function

// TODO could make this more universal if needed
/**
 * An Ajax post call used to alter html elements on the page to a username fetched from the server
 * @param dataToServer Contains any information you want to send to the server side
 * @param dataToChange The tag you want to change the html of to a username
 */
function ajaxCall(dataToServer, dataToChange) {
    $.ajax({
        url: 'updateAssignedUser',
        type: 'POST',
        dataType: 'json',
        data: dataToServer,
        success: function(dataToServer){
            if(dataToServer.isValid) {
                dataToChange.html(dataToServer.username);
            } else {
                alert('Please enter a registered Jonrah user');
            }
        }
    });
};

// TODO could make this more universal if needed
/**
 * This fetches all current usernames from the server for use in Assigning autocomplete using a GET method
 */
function fetchUserNames(usersCallback) {
    // Not sending any relevant information to the server
    var dataToServer = "";
    var userNameList = [];
    $.ajax({
        url: 'retrieveAllUserNames',
        type: 'GET',
        dataType: 'json',
        data: dataToServer,
        success: function(dataToServer){
            if(dataToServer.isValid) {
                usersCallback(dataToServer.usernames);
            } else {
                alert('There was an issue loading the page');
            }
        }
    });
}