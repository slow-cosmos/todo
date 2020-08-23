# TODO LIST
2020 - 08 - 23 ~ 2020 - 08 -24
Android Studio   
***

### 사용 방법

* ADD 버튼을 눌러 일정의 제목과 날짜 추가 가능   (날짜는 CheckBox를 통해 설정/비설정 가능)

* ListView 의 CheckBox를 통해 수행한 일정을 쉽게 알 수 있음

* 체크된 항목들은 일괄 제거 가능   
***

### 구현

* Dialog로 구현하려다 위젯 관리가 어려워 Activity Intent로 ADD 화면 구현

* CheckBox로 구현하려다 배열 구현이 어려워 ListView로 리스트 화면 구현

***

### 주요 코드

* ADD 버튼 (액티비티 간 값 전달)
<pre><code>
//MainActivity.java
add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });
</code></pre>
<pre><code>
//MainActivity.java
@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1){
            if(resultCode ==RESULT_OK){
                String todo = data.getStringExtra("Todo");
                midList.add(todo);
                adapter.notifyDataSetChanged();

            }
        }
    }
</code></pre>
<pre><code>
//SecondActivity.java
dlgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                if(dlgChk.isChecked()==true){
                    intent.putExtra("Todo",date.getMonth()+1+"/"+date.getDayOfMonth()+"  "+title.getText().toString());
                }else{
                    intent.putExtra("Todo",title.getText().toString());
                }

                setResult(RESULT_OK,intent);
                finish();
            }
        });
</code></pre>

* REMOVE 버튼 (체크된 항목 삭제)
<pre><code>
//MainActivity.java
remove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SparseBooleanArray array = list.getCheckedItemPositions();
                int count = adapter.getCount();

                for(int i = count-1;i>=0;i--){
                    if(array.get(i)){
                        midList.remove(i);
                    }
                }
                list.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });
</code></pre>

***

### 추가 될 항목

* 제목 변경

* 디자인 변경

* ADD 화면 다이얼로그 형식

* 날짜를 오른쪽으로    
***

### 블로그 / 실행 동영상
<https://blog.naver.com/inki1030/222068987072>
