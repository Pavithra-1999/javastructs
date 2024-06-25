<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<html:html>
<head>
	<title>Registeration</title>

</head>
<body>

	<html:form>
		<table>
			<tr>
				<th>
					First Name
				</th>
				<td>
					<html:text property="firstName"  />
				</td>
			</tr>
			<tr>
				<th>
					Last Name
				</th>
				<td>
					<html:text property="lastName"  />
				</td>
			</tr>
			<tr>
				<th>
					Mobile Number
				</th>
				<td>
					<html:text property="mobileNuber"  />
				</td>
			</tr>
		</table>
	</html:form>



</body>


</html:html>