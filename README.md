프로젝트 이름:
지옥에서 온 알람


팀원:
정승안, 이권은


프로젝트 설명:
탭1은 연락처 기능. 기기 내부에 저장된 연락처 불러오기 가능. Recycler View로 연락처 리스트 구현. 연락처 추가 가능. 연락처 추가 후 새로고침으로 추가한 알림까지 목록에 뜨게 할 수 있음.

탭2는 갤러리 기능. 기기 내부에 저장된 사진 불러오기 가능 (Glide, contentResolver). Recycler View+GridView Manager로 사진 목록이 뜨게 함. 특정 사진 클릭 시 크게 볼 수 있음(ImageView).

탭3는 알람 기능. 특정 시간에 알람을 설정해 놓으면 매일 반복되고, 알람 취소도 가능(alarmManager). 기상 음악이 매일 같을 경우 적응되어 깨지 않을 수 있기 때문에 4개 정도의 음악을 넣어놓고 랜덤함수로 선택함. 예약된 시간이 되면 랜덤으로 선택된 음악과 함께 수학문제가 나오는데, 정확도가 80% 이상이면 알람을 끌 수 있음. 미만일 경우 수학문제 activity 다시 실행.
