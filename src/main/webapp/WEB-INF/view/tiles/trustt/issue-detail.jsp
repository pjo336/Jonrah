<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">${issue.title}</h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-4">
                    <table class="table">
                        <tr>
                            <td>Type:</td>
                            <td>${issue.type.name}</td>
                        </tr>
                        <tr>
                            <td>Status:</td>
                            <td>${issue.status}</td>
                        </tr>
                    </table>
                </div>
                <div class="col-md-8">
                    <p>${issue.description}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row" style="margin-top:40px;">
            <div class="col-md-6">
                <div class="well well-sm">
                    <div class="text-right">
                        <a class="btn btn-success btn-green" href="#reviews-anchor" id="open-review-box">Leave a Review</a>
                    </div>

                    <div class="row" id="post-review-box" style="display:none;">
                        <div class="col-md-12">
                            <form accept-charset="UTF-8" action="" method="post">
                                <input id="ratings-hidden" name="rating" type="hidden">
                                <textarea class="form-control animated" cols="50" id="new-review" name="comment" placeholder="Enter your review here..." rows="5"></textarea>

                                <div class="text-right">
                                    <div class="stars starrr" data-rating="0"></div>
                                    <a class="btn btn-danger btn-sm" href="#" id="close-review-box" style="display:none; margin-right: 10px;">
                                        <span class="glyphicon glyphicon-remove"></span>Cancel</a>
                                    <button class="btn btn-success btn-lg" type="submit">Save</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>