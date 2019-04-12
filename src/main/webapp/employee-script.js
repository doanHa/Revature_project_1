function display(xhr) {
	console.log(xhr.responseText);
	clearTable();
	tickets = JSON.parse(xhr.responseText).ticket;
	table = document.getElementById("user-ticket");
		for ( let i in tickets) {

			let id = tickets[i]['ticketID'].toString();

			let amount = tickets[i]['reimbursementAmount'].toString();
			if (amount.includes('.')) {
			if(amount.length-amount.indexOf('.') == 2)
				amount = amount + "0";
			} else {
				amount = amount + ".00";
			}

			let status_ = "";
			if (tickets[i].ticketStatus == 1) {
				status_ = 'Pending';
			} else if (tickets[i].ticketStatus == 2) {
				status_ = 'Approved';
			} else {
				status_ = 'Denied';
			}

			let description = tickets[i]['ticketDescription'];

			let type = "";
			if (tickets[i].ticketType == 1) {
				type = 'Lodging';
			} else if (tickets[i].ticketType == 2) {
				type = 'Travel';
			} else {
				type = 'Food';
			}

			let submittedDate = tickets[i]['submittedDate'];

			let resolvedDate = tickets[i]['resolvedDate'];
			if(resolvedDate == null)
				resolvedDate ="N/A";

			let resolverid = tickets[i]['resolverID'];
			if(resolverid == 0) 
				resolverid = "N/A";

				
			newRow = document.createElement("tr");

		    newRow.innerHTML =
		        `<td>${id}</td>
				<td>${amount}</td>
				<td>${submittedDate}</td>
				<td>${description}</td>
				<td>${resolvedDate}</td>
				<td>${resolverid}</td>
				<td>${status_}</td>
		    	<td>${type}</td>`;

		    table.appendChild(newRow);
		}
		console.log('aa ' + table.rows.length);
}
function clearTable(){
	table = document.getElementById("user-ticket");
	for(var i = table. rows. length - 1; i > 0; i--)
	{
		table. deleteRow(i);
	}
}
document.getElementById("pending_button").onclick = function(){
	var xhttp2 = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhttp2.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			display(this);
		}
	};
	xhttp2.open("GET", "http://localhost:8080/ExpenseReimbursementSystem/getPending.change");
	xhttp2.send();
}

document.getElementById("resolved_button").onclick = function(){
	var xhttp2 = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhttp2.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			display(this);
		}
	};
	xhttp2.open("GET", "http://localhost:8080/ExpenseReimbursementSystem/getResolved.change");
	xhttp2.send();
}