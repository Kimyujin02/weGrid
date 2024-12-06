function uploadImage(event) {
    const file = event.target.files[0];  // 선택된 파일
    if (file) {
        const formData = new FormData();
        formData.append('profileImage', file);  // 서버에 전송할 파일

        // 서버로 이미지 업로드 요청
        fetch('/mypage/uploadProfileImage', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                // DB에 저장된 이미지 경로로 프로필 이미지 업데이트
                document.getElementById('profileImage').src = '/img/' + data.imagePath;
                window.location.reload(); // 페이지 전체를 새로고침
            } else {
                alert('이미지 업로드 실패');
            }
        })
        .catch(error => console.error('Error:', error));
    }
}


// 이벤트 리스너로 모달 열기
document.querySelector('.changePwd').addEventListener('click', function () {
    const changePwdModal = new bootstrap.Modal(document.getElementById('changePwdModal'));
    changePwdModal.show();
});

// // 비밀번호 검증 로직
// document.getElementById('changePwdForm').addEventListener('submit', function (event) {
//     event.preventDefault();
  
//     const currentPwd = document.getElementById('currentPwd').value;
//     const newPwd = document.getElementById('newPwd').value;
//     const confirmPwd = document.getElementById('confirmPwd').value;
  
//     if (newPwd !== confirmPwd) {
//       alert('새 비밀번호가 일치하지 않습니다.');
//       return;
//     }
  
//     // 서버로 비밀번호 변경 요청 보내기
//     console.log('비밀번호 변경 요청:', { currentPwd, newPwd });
//     alert('비밀번호가 성공적으로 변경되었습니다.');
// });