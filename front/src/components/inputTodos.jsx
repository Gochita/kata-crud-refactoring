import React from 'react'


const todositos = () => {
    // const { state: { todo } } = useContext(props.store);
    // const currentList = todo.list;
    return (
      <div>
        <div>nuevo todo</div>
        <input
          type="text"
          name="name"
          placeholder="¿Que hay pa hacer?"
          className="me-3"
        ></input>
       
        <button className="btn btn-success">Agregar todo</button>
      </div>
    );
  };
  
  export default Listtodositosilla;