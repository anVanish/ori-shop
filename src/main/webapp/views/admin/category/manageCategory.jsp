<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="form-container">
    <h2>${isUpdate ? 'Update' : "Add"} category</h2>
    <form action="" method="POST">
        <div class="form-group">
            <label for="categoryId">Category Id</label>
            <input type="number" id="categoryId" name="categoryId" disabled
            value="${not empty category ? category.categoryId : ''}">
        </div>

        <div class="form-group">
            <label for="categoryName">Name</label>
            <input type="text" id="categoryName" name="categoryName"
            value="${not empty category ? category.categoryName : ''}">
        </div>

        <button type="submit" class="btn">${isUpdate ? 'Update' : "Add"}</button>
    </form>
</div>