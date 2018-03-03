package xmts.gaintrain.Utils;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by xu on 3/3/18
 */

public class FirebaseUtils {
    private static final String TAG = "firebase_utils";

    private static FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();

    public static void test() {
        DatabaseReference temp = mDatabase.getReference();
        temp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                databaseError.getCode();
            }
        });
    }
}
