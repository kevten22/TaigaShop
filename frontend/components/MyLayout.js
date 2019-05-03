import Header from './Header'
import Navbar from './NavBar';
const layoutStyle = {
    margin: 20,
    padding: 20,
    border: '1px solid #DDD'
  }
  
  const Layout = props => (
    <div style={layoutStyle}>
      <Navbar />
      {props.children}
    </div>
  )
  
  export default Layout