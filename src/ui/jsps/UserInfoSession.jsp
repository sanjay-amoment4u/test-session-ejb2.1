<html>
	<head>
		<title>Examples...
		</title>		
	</head>
	<body onload="javascript:document.getElementById('txtEmpNameS').value='';document.getElementById('txtEmpNameS').focus();"> 
		<table>
			<tr>
				<td> 
					<h3>Session Bean Example</h3>
					<form action="ejbSessionBean" method="post">		
						Enter Employee (user) Name...	
						<input type='text' id='txtEmpNameS' name='txtEmpNameS' style='border:1px solid black;' title='Enter Employee Name...'/>						
						<input type="submit" value="Get Employee Info...">
					</form>	
				</td>
			</tr>					
		</table>		   
	</body>
</html>
