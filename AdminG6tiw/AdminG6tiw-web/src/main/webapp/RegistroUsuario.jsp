<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>


<head>
<title> Registro Dokulearning</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">

<!-- Latest compiled and minified CSS-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- CSS Validator-->
<link
	href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"
	rel="stylesheet"></link>


<!-- Optional theme-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="./style/styleHome.css">
<link rel="stylesheet" type="text/css" href="./style/styleFondoBlanco.css">

<!-- <!-- JavaScript
<script type="text/javascript" src="./script/validator.js"></script>
 -->
</head>

<body>

<div id="fondoBlanco" >
	<form name="formulario" method="post" class="form-horizontal mitad"
		action="ServletRegistroUsuario">

		<div class="container">
			<div class="row">
				<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
				<div class="col-xs-14 col-md-6">

					<h4>Informaci&oacute;n obligatoria</h4>


					<!-- Inputs-->

					<div class="form-group">
						<label for="usr">Usuario:</label> <input type="text"
							class="form-control" name="usuario" placeholder="Usuario"
							required id="usuario">
					</div>
					<div class="form-group">
						<label for="pwd">Clave</label> <input type="password"
							class="form-control" name="clave" placeholder="Clave" required
							id="clave">
					</div>

					<div class="form-group">
						<label for="name">Nombre</label> <input type="text"
							class="form-control" name="nombre" placeholder="Nombre" required
							id="nombre">
					</div>

					<div class="form-group">
						<label for="lastname">Apellidos</label> <input type="text"
							class="form-control" name="apellidos" placeholder="Apellidos"
							required id="apellidos">
					</div>

					<div class="form-group">
						<label for="edad">Edad</label> <input type="number"
							class="form-control" required id="edad" name="edad" min="18"
							max="120">
					</div>

					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" name="email"
							placeholder="ejemplo@dominio.com" required id="email">
					</div>

					<div class="form-group">
						<label for="tlf">Telefono:</label> <input type="tel"
							class="form-control" name="telefono" placeholder="Telefono"
							required id="telefono">
					</div>

					<div class="form-group">
						<label for="Dir">Direcci&oacute;n:</label>

						<textarea rows="3" class="form-control" name="direccion"
							placeholder="Direcci&oacute;n" required id="direccion"></textarea>
					</div>


					<h4>Informaci&oacute;n opcional</h4>

					<div class="form-group">
						<label for="desc">Descripci&oacute;n:</label>
						<textarea class="form-control" rows="5" name="descripcion"
							required id="descripcion"></textarea>
					</div>
					<div class="form-group">
						<label for="int">Intereses:</label>
						<textarea class="form-control" rows="5" name="intereses" required
							id="intereses"></textarea>
					</div>

					<!-- Metodo de pago-->

					<div class="panel panel-default credit-card-box">
						<div class="panel-heading display-table">
							<div class="row display-tr">
								<h3 class="panel-title display-td">Pago</h3>
								<div class="display-td">
									<img class="img-responsive pull-right"
										src="http://i76.imgup.net/accepted_c22e0.png">
								</div>
							</div>

							<div class="panel-body">

								<div class="row">
									<div class="col-xs-8">
										<div class="form-group">
											<label for="cardNumber">N&uacute;mero de tarjeta</label>
											<div class="input-group">
												<input type="tel" class="form-control" name="numeroTarjeta"
													placeholder="Numero válido de tarjeta"
													autocomplete="cc-number" required autofocus /> <span
													class="input-group-addon"><i
													class="fa fa-credit-card"></i></span>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-5 col-md-5">
										<div class="form-group">
											<label for="cardExpiry"><span class="hidden-xs">Expiraci&oacute;n</span><span
												class="visible-xs-inline">EXP</span></label> <input type="tel"
												class="form-control" name="expiracion" placeholder="MM / YY"
												autocomplete="cc-exp" required />
										</div>
									</div>
									<div class="col-xs-3 col-md-3 pull-left">
										<div class="form-group">
											<label for="cardCVC">C&oacute;digo CVC</label> <input
												type="tel" class="form-control" name="codigoCVC"
												placeholder="CVC" autocomplete="cc-csc" required />
										</div>
									</div>
								</div>


							</div>
							<div class="row" style="display: none;">
								<div class="col-xs-8">
									<p class="payment-errors"></p>
								</div>
							</div>

						</div>




						<button type="submit" class="btn btn-primary btn-lg btn-block">Registrarse</button>

					</div>

				</div>
			</div>
		</div>

	</form>
</div>	
	
	    <!--Pie de página-->
	<%@include file="Footer.jsp"%>

</body>



</html>