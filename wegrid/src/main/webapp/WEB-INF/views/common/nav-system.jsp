<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/common/nav.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro@4cac1a6/css/all.css" />

<script defer src="/js/common/nav.js"></script>

<!-- Nav -->
<nav>
    <div class="active-boc">
        <label onclick="location.href='/system/list'" class="navLabel">
            <div class="icon-boc">
              <i class="far fa-user-plus fa-2x"></i>
            </div>
            <div class="name-boc">계정관리</div>
        </label>
    </div>
    <div class="active-boc">
        <label onclick="location.href='/system/preference/list'" class="navLabel">
            <div class="icon-boc">
                <!-- <i class="fa-solid fa-gear fa-spin fa-2x"></i> -->
                <i class="fa-solid fa-wrench fa-2x"></i>
            </div>
            <div class="name-boc">환경설정</div>
        </label>
        
    </div>
</nav>