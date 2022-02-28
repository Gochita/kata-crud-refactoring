import React from "react";


const Todos = ({list}) => {
  return (
    <div>
      <div>nuevo todo</div>
      <form>
        <input
          type="text"
          name="name"
          placeholder="¿Que hay pa hacer?"
          className="me-3"
        ></input>
        <button className="btn btn-success">Agregar todo</button>
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
