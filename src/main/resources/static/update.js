
const accountVal = $('#accaunt').val();
const balanceVal = $('#balance').val();
$(document).ready(()=>{
    feather.replace()
    const addBtn = $('#add');
    console.log(accountVal);
    console.log(balanceVal);
    addBtn.click(e=>{
        const nameVal = $('#balance').val();
        console.log(accountVal);
        console.log(balanceVal);
        $.ajax({
            method: "PATCH",
            url: `/api/homebokkeeping/account/${accountVal}/`,
            contentType:"application/json",
            dataType:"json",
            data: JSON.stringify({
                "ammount": balanceVal
            }),
            cache: false,
        }).done(value=>{
            $('#balances').val('')
        })
    })
    feather.replace()
    const addBtn2 = $('#add2');
    addBtn2.click(e=>{
        const accountVale = $('#idaccaunt').val();
        const accountVale2 = $('#idtransaction').val();
        const descriptionVal = $('#description').val();
        $.ajax({
            method: "PATCH",
            url: `/api/homebokkeeping/account/${accountVale}/transaction/${accountVale2}`,
            contentType:"application/json",
            dataType:"json",
            data: JSON.stringify({
                "description": descriptionVal
            }),
            cache: false,
        }).done(value=>{
            $('#idaccaunt').val('')
            $('#description').val('')
        })
    })
})

/*
window.onload = async function () {
    const response = await fetch("/api/homebokkeeping/account", {
        method: "GET",
        headers: {"Accept": "application/json", "Content-Type": "application/json"}
    });

    console.log(response);
    console.log(response.ok);
    if (response.ok === true) {
        let accounts = await response.json();
        console.log(accounts);

        for (let account of accounts) {
            add_book(account);
        }
    }

    function add_book(account) {
        let books = document.getElementById("accounts");
        let row = document.createElement("tr");
        let name = document.createElement("td");
        name.innerHTML += `${account.accountId}`;
        row.appendChild(name);
        books.appendChild(row);
    }
}
*/
