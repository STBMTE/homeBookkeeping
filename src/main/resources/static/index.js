$(document).ready(async ()=> {

    const accounts = $('#accounts')
    const createItem = (json) => {
        const item = $(`<li class="item-section">
            <span>${json.ammount}</span>
        </li>`)
        const deleteBtn = $(feather.icons['x'].toSvg({ class: 'plus' }))
        const saleCheck = $(`<input type="text" value="${json.ammount}">`)
        item.append(saleCheck)
        item.append(deleteBtn)

        deleteBtn.click(()=>{
            console.log(json)
            $.ajax({
                method: "DELETE",
                url: `/api/homebokkeeping/${json.AccountId}`,
                contentType:"application/json",
                dataType:"json",
                cache: false,
            }).done(()=>{
                item.remove()
            }).fail(()=>{
                item.remove()
            })
        })
         .click(()=>{
            console.log(json)
            $.ajax({
                method: "PATCH",
                url: `/api/homebokkeeping/${json.AccountId}`,
                contentType:"application/json",
                dataType:"json",
                cache: false,
            }).done(value=>{
                console.log(value)
            }).fail(()=>{
            })
        })
        return item;
    }
    $.ajax({
        method: "GET",
        url: "/api/homebokkeeping/account",
        contentType:"application/json",
        dataType:"json",
        cache: false,
    }).done(value=>{
            console.log(value, value.length)
            if(value && value.length){
                value.forEach(x=>{
                    console.log(x)
                    accounts.append(createItem(x))
                })
            }
        })
})
