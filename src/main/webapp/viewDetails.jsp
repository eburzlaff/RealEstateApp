<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/28/22
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="includes/contentType.jsp" />
<html>
<head>
    <title>RS Properties - Individual Property</title>
    <jsp:include page="includes/head.jsp" />
</head>

<body>
<jsp:include page="includes/navbar.jsp" />
<h2 style="text-align: center; margin-bottom: 10px;">View Details - Property</h2>
<div class="d-flex  justify-content-around flex-column flex-wrap flex-lg-row ">
    <div class="card mx-5 my-5" style="width: 18rem;">
        <c:if test="${property.base64Image != null}" >
            <img src="data:image/jpg;base64,${property.base64Image}" class="card-img-top" alt="Property Image"/>
        </c:if>

        <div class="card-body">
            <h5 class="card-title">${property.address}</h5>
            <p class="card-text">${property.description}</p>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Type: ${property.propertyType}</li>
            <li class="list-group-item">For ${property.availabilityType}</li>
            <li class="list-group-item">Bedrooms: ${property.bedroomNumber}</li>
            <li class="list-group-item">Bathrooms: ${property.bathroomNumber}</li>
            <li class="list-group-item">Price: $${property.price}.00</li>
        </ul>
        <div class="card-body">
            <a href="requestTour" class="card-link"><button type="button" class="btn btn-success btn-block btn-lg gradient-custom-4">Request a Tour</button></a>
        </div>
    </div>
</div>
<jsp:include page="includes/footer.jsp" />
</body>
</html>


