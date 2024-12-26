import'./Header.css';
function Header(){

    return(
        <div className="header">
        <h1 className="app-name">Patient CRUD Application</h1>
        <nav>
            <ul>
                <li><a href="add-patient">Add Patient</a></li>
                <li><a href="list-patients">List Patients</a></li>
            </ul>
        </nav>
    </div>
    );
}

export default Header ;