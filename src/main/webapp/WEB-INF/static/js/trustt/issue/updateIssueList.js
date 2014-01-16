/**
 * Created by Peter Johnston on 1/14/14.
 */

/**
 * Uses an ajax call to update the assigned user to the correct issue in the issue list
 * Should pop up a menu when clicked to give the user options of available users to assign
 * Should also pop up a save option, which would initiate saving the changes in the database
 */
$(document).ready(function(){
    $('#assignUsers').submit(function() {
        $.ajax({
            url: 'updateAssignedUser',
            type: 'POST',
            dataType: 'json',
            data: $('#assignUsers'),
            success: function(data){
                if(data.isValid) {
                    var currentId = $('#assignedUserIssueId').val();
                    $('#assignedUser-' + currentId).html(data.username);
                } else {
                    alert('Please enter a registered Jonrah user');
                }
            }
        }); // End of ajax
        return false;
    }); // End of submit function
}); // End of ready function