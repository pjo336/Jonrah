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
    $('.inputAssignAccept').hide();

    // Hide the save button until it is needed
    $('#saveIssueChanges').hide();

    // Load all user names for auto complete
    fetchUserNames(function(users) {
        var assignButton = $('.assignUsersButtonMain');
        assignButton.click(function() {

            var currentId = this.getAttribute("id");
            var inputNameField = $('#inputAssignedUserName-' + currentId);
            var updatedDisplayedAssignedUser = $('#assignedUser-' + currentId);

            // When assign User is clicked, show the text box to enter a user
            showAssignUserInputField(currentId);

            // When the user clicks outside of the text box, hide the text box again
            inputNameField.blur(function() {
                assignButton.show(300);
                inputNameField.hide();
            });

            inputNameField.keydown(function(e) {
                var charCode = e.which;

                var userNamesDict = [];
                for(var i = 0; i < users.length; i++) {
                    userNamesDict.push({ value:users[i] , data:users[i]});
                }
                inputNameField.autocomplete({
                    source: userNamesDict,
                    noResults: ""
                });
                // Handle enter button to submit
                if(charCode == 13) {
                    submitUpdateAssignedUser(currentId);
                }
            });
            return false;
        }); // End of assign user button click
    });
}); // End of ready function

function showAssignUserInputField(currentId) {
    var inputNameField = $('#inputAssignedUserName-' + currentId);
    var assignButton = $('.assignUsersButtonMain');
    var assignedUserLink = $('#existingAssignedUser-' + currentId);
    inputNameField.show(200, function() {
        assignButton.hide();
        assignedUserLink.hide();
        inputNameField.focus();
    });
}
function submitUpdateAssignedUser(currentId) {
    var inputNameField = $('#inputAssignedUserName-' + currentId);
    var updatedDisplayedAssignedUser = $('#assignedUser-' + currentId);
    // Pass along the inputted user information to the server
    console.log(inputNameField.val());
    var data = {userInput : inputNameField.val(), issueId : currentId};
    updateAssignedUser(data, updatedDisplayedAssignedUser);
}
/**
 * An Ajax post call used to alter html elements on the page to a username fetched from the server
 * @param dataToServer Contains any information you want to send to the server side
 * @param dataToChange The tag you want to change the html of to a username
 */
function updateAssignedUser(dataToServer, dataToChange) {
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