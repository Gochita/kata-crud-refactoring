import React ,{useContext, useState}from "react";
import { agregarTodoContext } from "../contexts/ListContext";

const Todos = ({list}) => {

  const [todo, setTodo] = useState('')
  const addTodo= useContext(agregarTodoContext);
  const handleSubmit = (e) =>{
    e.preventDefault();
  //  console.log(todo);
    addTodo( todo,list.id);
    setTodo('');
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
            <tr key={todo.id} >
              <td>{todo.id}</td>
              <td>{todo.name}</td>
              <td>
                <input
                  type="checkbox"
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
