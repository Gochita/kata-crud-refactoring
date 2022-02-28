import React ,{useContext, useState}from "react";
import {  actualizarTodoContext, agregarTodoContext } from "../contexts/ListContext";


const Todos = ({list}) => {

  const tachado= {textDecoration: 'line-through'}
  const [todo, setTodo] = useState('')
  const addTodo= useContext(agregarTodoContext);
  const updateTodo= useContext(actualizarTodoContext);
  const handleSubmit = (e) =>{
    e.preventDefault();
    addTodo( todo,list.id);
    setTodo('');
  }

  const tachar = (todoComplete)=>{
    todoComplete.completed= !todoComplete.completed;
    updateTodo(todoComplete, list.id)
  }
  return (
    <div>
      <div>nuevo todo</div>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          placeholder="¿Que hay pa hacer?"
          className="me-3"
          value={todo}
          onChange={(e)=>setTodo(e.target.value)}
        ></input>
        <button className="btn btn-success"
         type="submit"
        >Agregar todo</button>
      </form>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Tarea</th>
            <th>¿Completado?</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {list.listaTodoModel.map((todo) => (
            <tr style={todo.completed? tachado : {}}
             key={todo.id} >
              <td>{todo.id}</td>
              <td>{todo.name}</td>
              <td>
                <input
                  type="checkbox"
                  onChange={()=>tachar(todo)}
                  defaultChecked={todo.completed}
                />
              </td>
              <td>
                <button 
                className="btn btn-secondary">Editar</button>
                <button 
                className="btn btn-danger">Eliminar</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      
    </div>
  );
};

export default Todos;
