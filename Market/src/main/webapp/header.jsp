<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://kit.fontawesome.com/187dabceeb.js" crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand" href="index.jsp"><i class="fa-solid fa-shop"></i></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="/productList.do">상품 목록</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/productForm.do">상품 등록</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/editProduct.do?edit=update">상품 편집</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/editProduct.do?edit=delete">상품 삭제</a>
        </li>
      </ul>
    </div>
  </div>
</nav>