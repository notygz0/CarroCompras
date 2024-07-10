<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarse</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link href="assets/css/estilos.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <jsp:include page="components/Navegacion.jsp" />
        <jsp:include page="components/Mensaje.jsp"/>
        <div class="container-fluid mt-3">
            <div class="row">
                <div class ="col-som-12">
                    <div class="card form-registro">
                        <div class="card-body">
                             <h5>Registrar Cuenta</h5>
                               <hr />
                               
                               <form action="ClienteControlador" method="post">
                                <div class="row">
                                    <div class="col-sm-6">
                                          <div class="mb-3">
                                              <label>Nombres: <span class="obligatorio">(*)</span> </label>
                                              <input value="${cliente.nombres}" type="text" class="form-control"required=""
                                                     name="nombres" placeholder="Ingrese su nombre"required=""/>         
                                          </div>
                                
                                    </div>
                                    
                                    <div class="col-sm-6">
                                          <div class="mb-3">
                                              <label>Apellidos: <span class="obligatorio">(*)</span> </label>
                                              <input value="${cliente.apellidos}" type="text" class="form-control"required=""
                                                     name="apellidos" placeholder="Ingrese sus apellidos" required=""/>         
                                          </div>
                                
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                          <div class="mb-3">
                                              <label>Telefono:</label>
                                              <input value="${cliente.telefono}" type="tel" class="form-control"
                                                     name="telefono" placeholder="Ingrese su telefono"/>         
                                          </div>
                                
                                    </div>
                                    
                        
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                          <div class="mb-3">
                                              <label>Correo Electronico: <span class="obligatorio">(*)</span></label>
                                              <input value="${cliente.correo}" type="email" class="form-control"
                                                     name="correo" placeholder="Ingrese su correo electronico" required=""/>         
                                          </div>
                                
                                    </div>
                                    
                        
                                </div>
                                <div class="row">
                                    <div c lass="col-sm-12">
                                          <div class="mb-3">
                                              <label>Contraseña: <span class="obligatorio">(*)</span></label>
                                              <input value="${cliente.password}" type="password" class="form-control"
                                                     name="password" placeholder="Ingrese su contraseña" required=""/>         
                                          </div>
                                
                                    </div>
                                    
                        
                                </div>
                                <input type="hidden" name="accion" value="guardar"/>
    <button type="submit" class="btn btn-dark">Registrar</button>
                            </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
        
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>