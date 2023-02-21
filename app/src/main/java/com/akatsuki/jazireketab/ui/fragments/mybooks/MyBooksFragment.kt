package com.akatsuki.jazireketab.ui.fragments.mybooks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.akatsuki.jazireketab.MainActivity
import com.akatsuki.jazireketab.R
import com.akatsuki.jazireketab.databinding.FragmentMyBooksBinding
import com.akatsuki.jazireketab.ui.fragments.mybooks.adapter.Mybooks_Adapter
import com.akatsuki.jazireketab.ui.fragments.mybooks.viewmodels.MyBooksViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyBooksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyBooksFragment : Fragment(),
    AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var catList = arrayListOf<String>()
    private var _binding: FragmentMyBooksBinding? = null
    private val binding get() = _binding!!
    private lateinit var status: Spinner

    private lateinit var _adapter: Mybooks_Adapter

    private var viewModel: MyBooksViewModel? = null
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
        _binding = FragmentMyBooksBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment

        (activity as MainActivity).hideActionbar()
        (activity as MainActivity).updatetitle("کتابخانه من")

        viewModel = ViewModelProvider(requireActivity())[MyBooksViewModel::class.java]
        _adapter = Mybooks_Adapter()

        val recyclerview = binding.recyclerViewMybooks
        val layout = GridLayoutManager(requireContext(), 3)
        recyclerview.layoutManager = layout
        recyclerview.adapter = _adapter

        viewModel?.response?.observe(requireActivity(), Observer {
            _adapter.items = it.data

        })

        catList = arrayListOf("در حال مطالعه", "تمام شده")
        status = binding.mybookStatus
        status.onItemSelectedListener = this




        return  view.rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyBooksFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyBooksFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun initStatus() {
        val itemsAdapter: ArrayAdapter<String> =

            ArrayAdapter<String>(requireContext(), R.layout.item_spinner_mybooks, catList).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                status.adapter = adapter
                adapter.setNotifyOnChange(true)
            }
    }



    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        /*ToastIcon("تغیر یافت")*/
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        /*ToastIcon("تغیر یافت")*/
    }
}