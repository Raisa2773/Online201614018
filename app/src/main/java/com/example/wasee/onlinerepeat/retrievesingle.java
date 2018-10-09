package com.example.wasee.onlinerepeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class retrievesingle extends AppCompatActivity {
    TextView name,address,gender,date,type,batch;
    DatabaseReference dRef;
    User user;
    Query q;
    FirebaseAuth fa;
    String useId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrievesingle);

        name=findViewById(R.id.tv1);
        address=findViewById(R.id.tv2);
        gender=findViewById(R.id.tv3);
        date=findViewById(R.id.tv4);
        type=findViewById(R.id.tv5);
        batch=findViewById(R.id.tv6);
        dRef= FirebaseDatabase.getInstance().getReference();
        fa=FirebaseAuth.getInstance();
        FirebaseUser user1=fa.getCurrentUser();
        useId=user1.getUid();
        q=dRef.orderByKey().equalTo(useId);
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot value:dataSnapshot.getChildren()){
                    user=value.getValue(User.class);
                }
                name.setText(user.getName());
                address.setText(user.getAddress());
                gender.setText(user.getGender());
                date.setText(user.getDate());
                type.setText(user.getType());
                batch.setText(user.getBatch());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
