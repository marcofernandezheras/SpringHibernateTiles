/**
 * Created by Marco A. Fernández Heras on 25/05/16.
 */
$(function(){

    /**
     * Get data from a form in JSON notation
     * @param $form to get data from
     * @returns an object with the data
     */
    function getFormData($form){
        var unindexed_array = $form.serializeArray();
        var indexed_array = {};

        $.map(unindexed_array, function(n){
            indexed_array[n['name']] = n['value'];
        });

        return indexed_array;
    }

    var pops = $('[data-toggle="popover"]');
    var pop = $(pops[0]);
    var timer = undefined;
    function showAndHidePopover(){
        pop.popover('show');
        if(timer){
            clearTimeout(timer);
        }
        timer = setTimeout(function(){
            pop.popover('hide');
        }, 2000);
    }

    function sendToCart( event ) {
        var formData = getFormData($(this));
        var that = this;
        $.ajax({
            type: "POST",
            url: $(this).attr( 'action' ),
            data: JSON.stringify(formData),
            contentType : "application/json",
            dataType : 'json',
            success: function(data)
            {
                if(data.code && data.code === 1){
                    $('#cartCountBadge').html(data.cartAmount);
                    if(formData['title']){
                        var tr = that.parentNode.parentNode;
                        if(data.lineAmount > 0){
                            $(tr.children[3]).html(data.lineAmount);
                            $(tr.children[4]).html(data.subtotal.toFixed(2));
                        }
                        else{
                            tr.remove();
                        }
                        $('#tdTotal').html(data.total.toFixed(2));
                    }
                    showAndHidePopover();
                }
            }
        });

        event.preventDefault();
    }

    $('form[name="cartAjaxForm"]').each(function(){
        $(this).submit(sendToCart);
    });
    pops.popover();
});