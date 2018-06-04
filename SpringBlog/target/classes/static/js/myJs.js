
var box = 0;

function createCommentBox() {
	
	
	
	if( box === 0 ){
	
	var newDiv = document.createElement("div");
	var newForm = document.createElement("form");
		newForm.className="col";
		newDiv.className="container py-2";
	
	var textArea = document.createElement("textarea")
		textArea.className="form-control";
		
	var button = document.createElement("input");
		button.className="btn btn-primary btn-sm";
		button.setAttribute("type","Submit");
		button.setAttribute("value","Send");
	
	newForm.appendChild(textArea);
	newForm.appendChild(button);
	newForm.setAttribute("th:action" , "@{/commentProcess}");
	newForm.setAttribute("method" , "POST");
	textArea.setAttribute("placeholder","Comment");
	newDiv.appendChild(newForm);
	newDiv.setAttribute("id", "mycomment")
	
	var commentDiv = document.getElementById("comments").appendChild(newDiv);
	box++;
	console.log(box)
	} 
	else {
		document.getElementById("mycomment").remove();
		box--;
	}
}