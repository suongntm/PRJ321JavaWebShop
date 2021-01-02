<%@include file="../../common/templates/backend/header.jsp" %>
<%@include file="../../common/templates/backend/navbar.jsp" %>

<section class="row">
    <article class="col">
        <div class="card" >
            <div class="card-header">
                Featured
            </div>
            <ul class="card-body">
                <form action="InsertCategoryController" method="post">
                    <div class="form-group">
                        <label for="categoryId">Category ID:</label>
                        <input type="text" class="form-control" id="categoryId"
                               name="categoryId" placeholder="Category ID">
                    </div>
                    
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name"
                               name="name" placeholder="Category Name">
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Add New" class="btn btn-primary">
                    </div>
                </form>
            </ul>
        </div>
    </article>
</section> <!--the hien phan main-->


<%@include file="../../common/templates/backend/footer.jsp" %>


