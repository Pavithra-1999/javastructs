<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<html:html>
<head>
	<title>AddUser</title>
</head>
<body>
	<html:form method="post" action="/adduser">
		<table>
			<tr>
				<th>
					First Name
				</th>
				<td>
					<html:text property="firstName"></html:text>
				</td>
			</tr>
			<tr>
				<th>
					Last Name
				</th>
				<td>
					<html:text property="lastName"></html:text>
				</td>
			</tr>
			<tr>
				<th>
					Email Id
				</th>
				<td>
					<html:text property="emailId"></html:text>
				</td>
			</tr>
			<tr>
				<th>
					Mobile Number
				</th>
				<td>
					<html:text property="mobileNo"></html:text>
				</td>
			</tr>
			<tr>
				<th>
					Passowrd
				</th>
				<td>
					<html:text property="pasword"></html:text>
				</td>
			</tr>
			<tr>
				<th>
					DOB
				</th>
				<td>
					<html:text property="dob"></html:text>
				</td>
			</tr>
			<td colspan="2">
				<html:submit>adduser</html:submit>
			</td>
			

		</table>
	</html:form>
</body>
</html:html>