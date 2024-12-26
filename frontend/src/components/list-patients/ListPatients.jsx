import React,{useState,useEffect} from 'react';
import { Link,useLocation,useNavigate } from 'react-router-dom';
import './ListPatients.css';
import PatientService from '../../services/PatientService.js';

function ListPatients() {

    const[patients,setPatients] = useState([]);

    const location = useLocation();
    const [successMessage,setSuccessMessage] = useState(location.state?.successMessage || '');
    const [errorMessage,setErrorMessage ]= useState(location.state?.errorMessage || '');

    const navigate = useNavigate();

    useEffect(()=>{
        fetchPatients();
    },[]);

    const fetchPatients = async () => {
      try {
        const data = await PatientService.getPatients();
        setPatients(data); 
      } catch (error) {
        console.error('Failed to fetch patients:', error);
        setErrorMessage('Failed to fetch patients. Please try again.');
      }
    };

   async function handleView(patientId) {
    console.log("HandleView Invoked : " + patientId);
      navigate('/patient-details',{
        state: { patientId: patientId }
      }
      );
  }
  
    async function handleDelete(patientId) {
      const isConfirmed = window.confirm("Do you want to proceed ?");
    
    if (isConfirmed) {
      try{
        const response = await PatientService.deletePatient(patientId);
        console.log(response);
        debugger
        if(response.status==204){
          console.log("Deleted Patient ID : " + patientId);
          setSuccessMessage(s=>s="Patient Deleted Successfully");
          setErrorMessage(e=>e="");
          fetchPatients();
        }
      } catch(error){
        setErrorMessage(e=>e="Patient Deletion failed");
        setErrorMessage(s=>s="");
      }
    } else {
      alert("Action canceled.");
    }
    }

    return(
        <div className="patient-list-container">
        <h2>List of Patients</h2>
        {successMessage && <p style={{ color: 'green',textAlign:'center' }}>{successMessage}</p>}
        {errorMessage && <p style={{ color: 'red' ,textAlign:'center'}}>{errorMessage}</p>}
        <table className="patient-table">
          <thead>
            <tr>
              <th>S.NO</th>
              <th>Name</th>
              <th>Email</th>
              <th>Age</th>
              <th>Mobile Number</th>
              <th>Created Date</th>
              <th>Updated Date</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {patients.map((patient,index) => (
              <tr key={patient.patientId}>
                <td>{index+1}</td>
                <td>{patient.patientName}</td>
                <td>{patient.email}</td>
                <td>{patient.age}</td>
                <td>{patient.mobileNumber}</td>
                <td>{patient.createdAt}</td>
                <td>{patient.updatedAt}</td>
                <td>
                  <button onClick={() => handleView(patient.patientId)}>View</button>
                  <Link to={`/update-patient/${patient.patientId}`}>
                  <button>Edit</button>
                  </Link>
                  <button onClick={() => handleDelete(patient.patientId)}>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );

}

export default ListPatients ; 