
$(document).ready(()=>{
    feather.replace()
    const addBtn = $('#add');
    addBtn.click(e=>{
        $.ajax({
            method: "POST",
            url: `/api/homebokkeeping/account`,
            contentType:"application/json",
            dataType:"json",
            data: JSON.stringify({
                "ammount": $('#name').val()
            }),
            cache: false,
        }).done(value=>{
            $('#name').val(' ')
        })
    })

})