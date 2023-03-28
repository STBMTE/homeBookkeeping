window.onload = async function () {
    const response = await fetch("/api/homebokkeeping/account", {
        method: "GET",
        headers: {"Accept": "application/json", "Content-Type": "application/json"}
    });

    async function deleted(iddel) {
        let deletResp = await fetch("/api/homebokkeeping/account/" + iddel, {
            method: "DELETE",
            headers: {"Accept": "application/json", "Content-Type": "application/json"}
        });
    }

    console.log(response);
    console.log(response.ok);
    if (response.ok === true) {
        let accounts = await response.json();
        console.log(accounts);

        for (let account of accounts) {
            add_elem(account);
        }
    }

    function add_elem(account) {
        let addr = "/api/homebokkeeping/account/" + account.accountId;
        let accounts = document.getElementById("accounts");
        let row = document.createElement("tr");
        let desc = document.createElement("td");
        let link = document.createElement("a");
        let delet = document.createElement("td");
        let button = document.createElement("button");
        desc.innerHTML = account.ammount;
        link.setAttribute("href", addr);
        link.appendChild(desc);
        row.appendChild(link);
        button.innerHTML = "Delete";
        button.addEventListener("click", function() {
            deleted(account.accountId);
        });
        delet.appendChild(button);
        row.appendChild(delet);
        accounts.appendChild(row);
    }

    $("#deleteBtn").click(function() {
        $.ajax({
            url: "/api/homebokkeeping/account/" + accountId,
            type: "DELETE",
            success: function(response) {
                console.log("success")
            },
            error: function(xhr) {
                console.log("error")
            }
        });
    });
}