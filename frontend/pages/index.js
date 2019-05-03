import Layout from '../components/MyLayout.js'
import fetch from 'isomorphic-unfetch'


const Index = () => (
    <Layout>
      <h1>Welcome to Taiga</h1>
    </Layout>
  )

  Index.getInitialProps = async function() {
    //const res = await fetch('placeholderurl')
    //const data = await res.json()

    return {
    }
  }
  
  export default Index