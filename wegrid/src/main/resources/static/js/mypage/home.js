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
