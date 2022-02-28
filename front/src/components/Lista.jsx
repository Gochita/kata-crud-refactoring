import React from "react";

const Todos = () => {
  // const { state: { todo } } = useContext(props.store);
  // const currentList = todo.list;
  return (
    <div>
      <div>Crea nuevas listas</div>
      <input
        type="text"
        name="name"
        placeholder="¿Que mas quieres hacer?"
      ></input>
      <button className="btn btn-success">Agregar Lista</button>
    </div>
  );
};

export default Todos;
