import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel:ViewModel() {

    private val _stateFlow = MutableStateFlow("Hello")

    val stateFlow = _stateFlow.asStateFlow()

    private val _sharedFlow=MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    //Emit the data in stateFlow
    fun updateStateFlow(){
        viewModelScope.launch {
            _stateFlow.emit("Hello World")
        }
    }
    //Emit data in sharedFlow
    fun updateSharedFlow(){
        viewModelScope.launch {
            _sharedFlow.emit("Hello sharedFlow")
        }
    }
}