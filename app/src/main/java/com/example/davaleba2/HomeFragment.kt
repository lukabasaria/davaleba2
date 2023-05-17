import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.davaleba2.ListFragment
import com.example.davaleba2.ProfileFragment
class HomeFragment : Fragment() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var gpaEditText: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        firstNameEditText = view.findViewById(R.id.edit_text_first_name)
        lastNameEditText = view.findViewById(R.id.edit_text_last_name)
        gpaEditText = view.findViewById(R.id.edit_text_gpa)

        val gotoProfileButton = view.findViewById<Button>(R.id.button_goto_profile)
        gotoProfileButton.setOnClickListener {
            val profileFragment = ProfileFragment()
            val args = Bundle()
            args.putString("firstName", firstNameEditText.text.toString())
            args.putString("lastName", lastNameEditText.text.toString())
            args.putString("gpa", gpaEditText.text.toString())
            profileFragment.arguments = args
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, profileFragment).addToBackStack(null).commit()
        }

        val clearAllButton = view.findViewById<Button>(R.id.button_clear_all)
        clearAllButton.setOnClickListener {
            firstNameEditText.setText("")
            lastNameEditText.setText("")
            gpaEditText.setText("")
        }

        val gotoListButton = view.findViewById<Button>(R.id.button_goto_list)
        gotoListButton.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, ListFragment()).addToBackStack(null).commit()
        }

        return view
    }
}
