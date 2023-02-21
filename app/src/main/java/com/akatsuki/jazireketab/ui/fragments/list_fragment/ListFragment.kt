package com.akatsuki.jazireketab.ui.fragments.list_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.akatsuki.jazireketab.MainActivity
import com.akatsuki.jazireketab.R
import com.akatsuki.jazireketab.databinding.FragmentListBinding
import com.akatsuki.jazireketab.databinding.FragmentShareBinding
import com.akatsuki.jazireketab.ui.fragments.list_fragment.adapter.List_Adapter
import com.akatsuki.jazireketab.ui.fragments.mybooks.adapter.Mybooks_Adapter
import com.akatsuki.jazireketab.ui.fragments.mybooks.viewmodels.MyBooksViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var _adapter: List_Adapter
    private var viewModel: ListViewModel? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        (activity as MainActivity).hideActionbarFr()
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true);
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true);

        viewModel = ViewModelProvider(requireActivity())[ListViewModel::class.java]
        _adapter = List_Adapter()

        val recyclerview = binding.recyclerViewList
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerview.layoutManager = layout
        recyclerview.adapter = _adapter

        viewModel?.response?.observe(requireActivity(), Observer {
            _adapter.items = it.listBooks
            (activity as MainActivity).updatetitle(it.subject.toString())


        })


        return view.rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}