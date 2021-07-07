
프로젝트 이름:
지옥에서 온 알람


팀원:
정승안, 이권은


프로젝트 설명:
=======
#프로젝트 이름:
지옥에서 온 알람


#팀원:
정승안, 이권은


#프로젝트 설명:

탭1은 연락처 기능. 기기 내부에 저장된 연락처 불러오기 가능. Recycler View로 연락처 리스트 구현. 연락처 추가 가능. 연락처 추가 후 새로고침으로 새로 등록한 연락처까지 뜨는것 까지 구현함.

탭2는 갤러리 기능. 기기 내부에 저장된 사진 불러오기 가능 (Glide, contentResolver). Recycler View+GridView Manager로 사진 목록이 뜨게 함. 특정 사진 클릭 시 크게 볼 수 있음(ImageView).

탭3는 알람 기능. 특정 시간에 알람을 설정해 놓으면 매일 반복되고, 알람 취소도 가능(alarmManager). 기상 음악이 매일 같을 경우 적응되어 깨지 않을 수 있기 때문에 4개 정도의 음악을 넣어놓고 랜덤함수로 선택함. 예약된 시간이 되면 랜덤으로 선택된 음악과 함께 수학문제가 나오는데, 정확도가 80% 이상이면 알람을 끌 수 있음. 미만일 경우 수학문제 activity 다시 실행.
또한, 무조건 일어나고자 하는 알람앱의 목저에 맞게, 볼륨 조절을 못하도록 key입력을 block하였고, 홈버튼이나 멀티태스크 버튼으로 알람을 종료할 수 없도록 service를 이용하여 최상단에 뷰를 띄워놓아, 수학 문제를 모두 풀기 전까지 앱을 종료 못하게 구현하였다!!

=======



![Screenshot_20210706-221647_    ](https://user-images.githubusercontent.com/63151413/124607284-a6d85700-dea8-11eb-9408-4776c0521734.jpg)
![Screenshot_20210706-221652_    ](https://user-images.githubusercontent.com/63151413/124607314-af309200-dea8-11eb-9b81-4282efa41f13.jpg)
![Screenshot_20210706-221655_    ](https://user-images.githubusercontent.com/63151413/124607329-b35caf80-dea8-11eb-9dab-a3e84e38588c.jpg)
![Screenshot_20210706-221810_    ](https://user-images.githubusercontent.com/63151413/124607347-b788cd00-dea8-11eb-8b72-c9fa489aba9e.jpg)
![Screenshot_20210706-221922_    ](https://user-images.githubusercontent.com/63151413/124607368-bd7eae00-dea8-11eb-98b7-440cd40a6fe2.jpg)

