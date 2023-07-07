package com.example.notesapp.Adapter

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.AddNote
import com.example.notesapp.Models.Note
import com.example.notesapp.R
import com.example.notesapp.UpdateNote
import java.util.Random

class NotesAdapter(private val context: Context,private val arr:List<Note>,val listener:NotesitemClickListener):RecyclerView.Adapter<NotesAdapter.NoteViewholder>(){

    inner class NoteViewholder(itemView: View):RecyclerView.ViewHolder(itemView){
          val title=itemView.findViewById<TextView>(R.id.tv_title)
        val note=itemView.findViewById<TextView>(R.id.tv_note)
        val date=itemView.findViewById<TextView>(R.id.tv_date)
         val card=itemView.findViewById<CardView>(R.id.cardLay)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewholder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return NoteViewholder(v)
    }

    override fun getItemCount(): Int {
       return arr.size
    }

    override fun onBindViewHolder(holder: NoteViewholder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent= Intent(context, UpdateNote::class.java)
            intent.putExtra("id",arr.get(position).id)
            intent.putExtra("title",arr.get(position).title)
            intent.putExtra("note",arr.get(position).note)
            context.startActivity(intent)
        }
        holder.itemView.setOnLongClickListener {
            listener.onLongitemClicked(arr[holder.adapterPosition],holder.card)
            true
        }
//        holder.card.setOnClickListener{
//            listener.getItemclicked(arr[holder.adapterPosition])
//        }
//        holder.card.setOnLongClickListener {
//
//        }
       holder.title.text=arr.get(position).title
        holder.title.isSelected=true
        holder.note.text=arr.get(position).note
holder.date.text=arr.get(position).date
        holder.date.isSelected=true
        holder.card.setCardBackgroundColor(holder.itemView.resources.getColor(randomColor(),null))
    }

    fun randomColor():Int
    {
        val list=ArrayList<Int>()
         list.add(R.color.NoteColor1)
        list.add(R.color.NoteColor2)
        list.add(R.color.NoteColor3)
        list.add(R.color.NoteColor4)
        list.add(R.color.NoteColor5)
        list.add(R.color.NoteColor6)
        val seed=System.currentTimeMillis().toInt()
        val randomIndex=Random(seed.toLong()).nextInt(list.size)
        return list[randomIndex]

    }
    interface NotesitemClickListener{
        //    fun getItemclicked(note:Note)
        fun onLongitemClicked(note:Note,cardView: CardView)

    }

}
