package edu.rosehulman.historicaldocs


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_doc_detail.view.*

private const val ARG_DOC = "doc"

class DocDetailFragment : Fragment() {
    private var doc: Doc? = null

    companion object {
        @JvmStatic
        fun newInstance(doc: Doc) =
            DocDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_DOC, doc)
                }
            }

        fun newInstance2(doc: Doc): DocDetailFragment {
            val fragment = DocDetailFragment()
            fragment.arguments = Bundle()
            fragment.arguments!!.putParcelable(ARG_DOC, doc)
            return fragment
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        doc = arguments?.getParcelable(ARG_DOC)
        arguments?.let {
            doc = it.getParcelable(ARG_DOC)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doc_detail, container, false)
        view.fragment_doc_detail_title.text = doc?.title
        view.fragment_doc_detail_body.text = doc?.text
        return view
    }

}
