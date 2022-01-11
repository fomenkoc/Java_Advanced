"use strict";

$("button.createProduct")
		.click(
				function() {
					
					let name = $("form.createProduct input.productName").val();
					let description = $("form.createProduct input.productDescription").val();
					let price = $("form.createProduct input.productPrice").val();
				
						let product = {
								name : name,
								description : description,
								price : price
						};
//add validation
						$.post("product", product,
								function(data) {
									if (data == 'Success') {
//										$("form")[0].reset();
//										$("form")[1].reset();
//										showAlertAfterRegistration();
										alert('Success');
									}
								});
					
				});
