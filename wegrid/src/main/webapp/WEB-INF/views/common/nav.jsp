<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/common/nav.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro@4cac1a6/css/all.css" />

<script defer src="/js/common/nav.js"></script>

<!-- Nav -->
<nav>
    <div class="active-boc">
        <label onclick="location.href='/project/card'" class="navLabel">
            <div class="icon-boc">
              <i class="far fa-file fa-2x"></i>
            </div>
            <div class="name-boc">프로젝트</div>
        </label>
    </div>
    <div class="active-boc">
        <label onclick="location.href='/calendar/mainCalendar'" class="navLabel">
            <div class="icon-boc">
                <i class="fas fa-calendar-alt fa-2x"></i>
            </div>
            <div class="name-boc">캘린더</div>
        </label>
        
    </div>
    <div class="active-boc">
        <label onclick="location.href='/crm/list'" class="navLabel">
            <div class="icon-boc">
                <i class="fas fa-user-friends fa-2x"></i>
            </div>
            <div class="name-boc">고객사</div>
        </label>
    </div>
    <div class="active-boc">
        <label onclick="location.href='/trip/list'" class="navLabel">
            <div class="icon-boc">
                <i class="fas fa-business-time fa-2x"></i>
            </div>
            <div class="name-boc">출장</div>
        </label>
    </div>
    <div class="active-boc">
        <label  onclick="location.href='/vacation/menu'" class="navLabel">
            <div class="icon-boc">
                <svg width="38" height="35" viewBox="0 0 38 35" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M29.6159 6.56154C30.5673 6.56154 31.4797 6.21589 32.1525 5.60062C32.8252 4.98536 33.2032 4.15088 33.2032 3.28077C33.2032 2.41066 32.8252 1.57618 32.1525 0.960915C31.4797 0.345651 30.5673 0 29.6159 0C28.6645 0 27.752 0.345651 27.0793 0.960915C26.4065 1.57618 26.0286 2.41066 26.0286 3.28077C26.0286 4.15088 26.4065 4.98536 27.0793 5.60062C27.752 6.21589 28.6645 6.56154 29.6159 6.56154ZM23.3157 13.704C23.3905 13.6767 23.4577 13.6494 23.5324 13.622L22.2694 17.9622C21.8509 19.4044 22.262 20.9422 23.368 22.0427L28.6518 27.3124L30.296 33.334C30.6173 34.5028 31.9177 35.2204 33.1957 34.9265C34.4737 34.6326 35.2584 33.4433 34.937 32.2746L33.2181 25.9796C33.0761 25.4465 32.7846 24.9612 32.3811 24.5579L28.6817 20.8671L30.1241 16.3902L30.8415 17.9622C31.1704 18.6867 31.7757 19.2814 32.5455 19.6368L34.5409 20.5458C35.7217 21.0858 37.1566 20.6483 37.7471 19.5684C38.3375 18.4885 37.8592 17.1762 36.6783 16.6362L35.0715 15.9049L33.9281 13.3896C32.6427 10.5805 29.6383 8.74872 26.3051 8.74872C24.6012 8.74872 22.9196 9.0768 21.3651 9.70561L20.7673 9.94483C18.3085 10.9427 16.4251 12.8428 15.5806 15.1736L15.3863 15.7067C14.9678 16.855 15.6479 18.0921 16.896 18.4748C18.144 18.8576 19.5042 18.2356 19.9227 17.0942L20.1171 16.5611C20.543 15.3923 21.4847 14.4491 22.7104 13.9501L23.3082 13.7109L23.3157 13.704ZM21.0737 22.938L19.2053 27.203L14.766 31.263C13.8318 32.1174 13.8318 33.5049 14.766 34.3592C15.7002 35.2136 17.2173 35.2136 18.1515 34.3592L22.7627 30.1421C23.1065 29.8277 23.3755 29.4517 23.5549 29.0416L24.6385 26.5674L21.5968 23.5327C21.41 23.3481 21.2381 23.1499 21.0737 22.9449V22.938ZM16.4625 18.7346C15.8871 18.4338 15.1621 18.6115 14.8258 19.1378L12.4343 22.9244L8.36871 20.7782C7.22526 20.1767 5.76045 20.5321 5.10279 21.5779L0.319744 29.1578C-0.337924 30.2036 0.0506979 31.5432 1.19414 32.1447L5.33446 34.3319C6.47791 34.9334 7.94272 34.5779 8.60039 33.5322L13.3834 25.9523C13.4955 25.7745 13.5777 25.5968 13.6301 25.4055L16.9034 20.2314C17.2323 19.7051 17.038 19.0421 16.4625 18.7346Z" fill="white"/>
                </svg>
            </div>
            <div class="name-boc">휴가</div>
        </label>
    </div>
    <div class="active-boc">
        <label  onclick="location.href='/notice/list'" class="navLabel">
            <div class="icon-boc">
                <i class="fas fa-bullhorn fa-2x"></i>
            </div>
            <div class="name-boc">공지사항</div>
        </label>
    </div>
    <div class="active-boc">
        <label  onclick="location.href='/board/list'" class="navLabel">
            <div class="icon-boc">
                <i class="far fa-clipboard fa-2x"></i>
            </div>
            <div class="name-boc">게시판</div>
        </label>
    </div>
    <div class="active-boc">
        <label  onclick="location.href='/familyEvent/list'" class="navLabel">
            <div class="icon-boc">
                <i class="fas fa-bullhorn fa-2x"></i>
            </div>
            <div class="name-boc">경조사게시판</div>
        </label>
    </div>
    <div class="active-boc">
        <label  onclick="toggleList();" class="navLabel">
            <div class="icon-boc">
                <i class="fas fa-file-signature fa-2x"></i>
            </div>
            <div class="name-boc">결재</div>
        </label>
    </div>
    <label class="navLabel" onclick="location.href='/approval/submitList'"><div id="submitListt">결재 상신함</div></label>
    <label class="navLabel" onclick="location.href='/approval/receiveList'"><div id="receiveListt">결재 수신함</div></label>
    

</nav>