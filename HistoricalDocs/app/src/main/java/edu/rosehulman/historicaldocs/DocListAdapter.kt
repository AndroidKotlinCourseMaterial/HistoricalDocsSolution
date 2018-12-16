package edu.rosehulman.historicaldocs

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.row_view_doc.view.*

class DocListAdapter(var context: Context?, var listener: DocListFragment.OnDocSelectedListener?) : RecyclerView.Adapter<DocListAdapter.DocViewHolder>() {

    var docs = ArrayList<Doc>()

    init {
       docs = DocUtils.loadDocs(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_view_doc, parent, false)
        return DocViewHolder(view)
    }

    override fun onBindViewHolder(holder: DocViewHolder, position: Int) {
        holder.bind(docs[position])
    }
    override fun getItemCount() = docs.size

    // Inner classes must be declared as such. It's small, so we are willing to
    // deal with the complexity.
    inner class DocViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.document_title_text_view

        init {
            itemView.setOnClickListener {
                listener?.onDocSelected(docs[adapterPosition])
            }
        }

        fun bind(doc: Doc) {
            titleTextView.text = doc.title
        }
    }
}