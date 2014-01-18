/**
 * Created by Peter Johnston on 1/14/14.
 */

/**
 * Uses an ajax call to update the assigned user to the correct issue in the issue list
 * Should pop up a menu when clicked to give the user options of available users to assign
 * Should also pop up a save option, which would initiate saving the changes in the database
 */
$(document).ready(function(){
    // Hide all assign users text inputs on page load
    $('.inputAssignedUserName').hide();

    $('.assignUsersButtonMain').click(function() {

        var currentId = this.getAttribute("id");
        var form = $('#assignUsersForm-' + currentId);
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

//        inputNameField.keydown(function(e) {
//            if (e.keyCode == 13) {
//                form.submit(function() {
//                    $.ajax({
//                        url: 'updateAssignedUser',
//                        type: 'POST',
//                        dataType: 'json',
//                        data: form,
//                        success: function(data){
//                            if(data.isValid) {
//                                updatedDisplayedAssignedUser.html(data.username);
//                            } else {
//                                alert('Please enter a registered Jonrah user');
//                            }
//                        }
//                    })
//                })
//            }
//        });

        inputNameButton.click(function() {
            form.submit(function() {
                $.ajax({
                    url: 'updateAssignedUser',
                    type: 'POST',
                    dataType: 'json',
                    data: form,
                    success: function(data){
                        if(data.isValid) {
                            updatedDisplayedAssignedUser.html(data.username);
                        } else {
                            alert('Please enter a registered Jonrah user');
                        }
                    }
                })
            })
        }); // End of click

        console.log("Reached end of JS");
        return false;
    }); // End of assign user button click
}); // End of ready function