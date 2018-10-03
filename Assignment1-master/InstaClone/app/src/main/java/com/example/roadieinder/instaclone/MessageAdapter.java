package com.example.roadieinder.instaclone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    public List<Message> messages;
    private  Context context;

    public MessageAdapter(Context context, List<Message> messages) {
        this.messages = messages;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        boolean isPhotoMessage = messages.get(position).getPhotoUrl() != null;
        if (isPhotoMessage) {
            holder.message.setVisibility(View.GONE);
            holder.authorName.setText(messages.get(position).getAuthor());
            Glide.with(context)
                    .load(messages.get(position).getPhotoUrl()).into(holder.imageView);

        } else {
            holder.imageView.setVisibility(View.GONE);

            holder.message.setText(messages.get(position).getMessage());
            holder.authorName.setText(messages.get(position).getAuthor());
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MessageHolder extends RecyclerView.ViewHolder {
        TextView authorName;
        TextView message;
        ImageView imageView;

        public MessageHolder(View itemView) {
            super(itemView);

            authorName = itemView.findViewById(R.id.authorTextView);
            message = itemView.findViewById(R.id.messageTextView);
            imageView = itemView.findViewById(R.id.photoImageView);
        }
    }
}

