package com.example.kirill.greenme;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.RatingAdapterViewHolder>{

    private String[] mData;
    private String[] dataName = {"Ivan Ivanov", "Liza Vasina", "Kate Ivanova", "July Petrova","Stas Pipika","Masha Shira","Kim","Dima Hello","Dima Pool"};
    private String[] dataScore = {"265", "143", "123", "110","90","88","83","76","75"};
    private String[] dataPosition = {"1", "2", "3" , "4", "5", "6", "7", "8", "9"};
    private Context mContext;
    public static class RatingAdapterViewHolder extends RecyclerView.ViewHolder {
        final TextView mPosition;
        final TextView mName;
        final TextView mScore;
        final ImageView mUser;
        //final ImageView mStar;
        public RatingAdapterViewHolder(View view) {
            super(view);
            mPosition = (TextView)view.findViewById(R.id.position);
            mName = (TextView) view.findViewById(R.id.name);
            mScore = view.findViewById(R.id.scores);
            mUser = view.findViewById(R.id.user);
            //mStar = view.findViewById(R.id.star);

           // view.setOnClickListener(this);
        }

    }

    public RatingAdapter(Context context) {
        mContext = context;
//        mData = myDataset;
    }


    @NonNull
    @Override
    public RatingAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = R.layout.rating_item;
        View view = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        view.setFocusable(true);

        return new RatingAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RatingAdapterViewHolder holder, int position) {
        holder.mName.setText(dataName[position]);
        holder.mScore.setText(dataScore[position]);
        holder.mPosition.setText(dataPosition[position]);

        if (position == 0) {
            holder.mUser.setImageResource(R.drawable.face1);
        }
        if (position == 1) {
            holder.mUser.setImageResource(R.drawable.face2);
        }
        if (position == 2) {
            holder.mUser.setImageResource(R.drawable.face2);
        }
        if (position == 3) {
            holder.mUser.setImageResource(R.drawable.face2);
        }
        if (position == 4) {
            holder.mUser.setImageResource(R.drawable.face1);
        }
        if (position == 5) {
            holder.mUser.setImageResource(R.drawable.face2);
        }
        if (position == 6) {
            holder.mUser.setImageResource(R.drawable.face3);
        }
        if (position == 7) {
            holder.mUser.setImageResource(R.drawable.face1);
        }
        if (position == 8) {
            holder.mUser.setImageResource(R.drawable.face2);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 8;
    }


        //
//    private final Context mContext;
//    final private RatingAdapterOnClickHandler mClickHandler;
//    private Cursor mCursor;
//
//    public interface RatingAdapterOnClickHandler {
//        void onClick(long date);
//    }
//
//    public RatingAdapter(@NonNull Context context, RatingAdapterOnClickHandler clickHandler) {
//        mContext = context;
//        mClickHandler = clickHandler;
//    }
//
//    @NonNull
//    @Override
//    public RatingAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        int layoutId = R.layout.rating_item;
//        View view = LayoutInflater.from(mContext).inflate(layoutId, viewGroup, false);
//        view.setFocusable(true);
//        return new RatingAdapterViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RatingAdapterViewHolder holder, int position) {
//        mCursor.moveToPosition(position);
//        int lauoutId =
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    public class RatingAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        final TextView mPostion;
//        final TextView mName;
//        final TextView mScore;
//        final ImageView mUser;
//
//        public RatingAdapterViewHolder(View view) {
//            super(view);
//            mPostion = (TextView)view.findViewById(R.id.position);
//            mName = (TextView) view.findViewById(R.id.name);
//            mScore = view.findViewById(R.id.scores);
//            mUser = view.findViewById(R.id.user);
//
//            view.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            int addapterPosition = getAdapterPosition();
//            mCursor.moveToPosition(addapterPosition);
//        }
//    }
}
