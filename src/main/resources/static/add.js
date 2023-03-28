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


$(document).ready(()=>{
    feather.replace()
    const addBtn = $('#add');
    addBtn.click(e=>{
        const nameVal = $('#name').val();
        $.ajax({
            method: "POST",
            url: "/api/homebokkeeping/account",
            contentType:"application/json",
            dataType:"json",
            data: JSON.stringify({
                "ammount": nameVal
            }),
            cache: false,
        }).done(value=>{
            $('#name').val('')
        })
    })

    const addBtn2 = $('#add2');
    addBtn2.click(e=>{
        const accountVal = $('#idaccaunt').val();
        const descriptionVal = $('#description').val();
        const ammountVal = $('#ammount').val();
        $.ajax({
            method: "POST",
            url: `/api/homebokkeeping/account/${accountVal}/transaction`,
            contentType:"application/json",
            dataType:"json",
            data: JSON.stringify({
                "ammount": ammountVal,
                "description": descriptionVal
            }),
            cache: false,
        }).done(value=>{
            $('#idaccaunt').val('')
            $('#description').val('')
            $('#ammount').val('')
        })
    })
})