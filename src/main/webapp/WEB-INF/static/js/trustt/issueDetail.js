$( document ).ready(function() {
    var $this = $(this);
    $this.closest('ul').find('.active').removeClass('active');
    var issues = $('#issues-sidebar');
    issues.addClass('active');
});

$(function(){

    var reviewBox = $('#post-review-box');
    var newReview = $('#new-review');
    var openReviewBtn = $('#open-review-box');
    var closeReviewBtn = $('#close-review-box');

    openReviewBtn.click(function(e)
    {
        e.preventDefault();
        reviewBox.slideDown(400, function()
        {
            $('#new-review').trigger('autosize.resize');
            newReview.focus();
        });
        openReviewBtn.fadeOut(100);
        closeReviewBtn.show();
    });

    closeReviewBtn.click(function(e)
    {
        e.preventDefault();
        reviewBox.slideUp(300, function()
        {
            newReview.focus();
            openReviewBtn.fadeIn(200);
        });
        closeReviewBtn.hide();

    });
});