$(document).ready(function () {

    var rootURL = 'http://localhost:8091/api';

    $(document).on("click", "#lnkSwish", function () {
        $lnkSwish = $(this);
        //getting the next element
        $content = $lnkSwish.next();
        //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
        $content.slideToggle(500, function () {
            //execute this after slideToggle is done
            //change text of header based on visibility of content div
            $content.text(function () {
                //change text based on condition
                return $content.is(":visible") ? "Collapse" : "Expand";
            });
        });

    });
});