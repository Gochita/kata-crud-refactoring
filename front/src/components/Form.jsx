import React, { useRef, useState, useContext } from 'react'


const Form = (props) => {
    const formRef = useRef(null);
    const { dispatch, state: { todo } } = useContext(props.Store);
    const item = todo.item;
    const [state, setState] = useState(item);
  
    const onAdd = (event) => {
     
      event.preventDefault();
      console.log(state.name)
      if(state.name=== undefined || state.name.match("^\\s+$")) return;
      
      const request = {
        name: state.name,
        id: null,
        completed: false
      };
  
  
      fetch(props.HOST_API+ "/todolist", {
        method: "POST",
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(response => response.json())
        .then((todo) => {
          dispatch({ type: "add-item", item: todo });
          setState({ name: "" });
          formRef.current.reset();
        });
    }
  
    const onEdit = (event) => {
      
      event.preventDefault();
      if(state.name=== undefined || state.name.match("^\\s+$")) return;
  
      const request = {
        name: state.name,
        id: item.id,
        isCompleted: item.isCompleted
      };
  
  
      fetch(props.HOST_API + "/actualizarLista", {
        method: "PUT",
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(response => response.json())
        .then((todo) => {
          dispatch({ type: "update-item", item: todo });
          setState({ name: "" });
          formRef.current.reset();
        });
    }
  
    return <form ref={formRef}>
      <input
        type="text"
        name="name"
        placeholder="¿Qué piensas hacer hoy?"
        defaultValue={item.name}
        onChange={(event) => {
          setState({ ...state, name: event.target.value })
        }}  ></input>
      {item.id && <button className="btn btn-info" onClick={onEdit}>Actualizar</button>}
      {!item.id && <button className="btn btn-success" onClick={onAdd}>Crear</button>}
    </form>
  }

  
export default Form