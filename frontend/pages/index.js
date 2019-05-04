import Layout from '../components/MyLayout.js'
import fetch from 'isomorphic-unfetch'


const Index = (props) => (
    <Layout>
      <h1>Welcome to Taiga</h1>
      <div>
        {props.products.map(product=> (
          <div>
            <p>{product.productname}</p>
            <p>{product.productprice}</p>
            <img src={product.imageurl}></img>
          </div>
        ))}
      </div>
    </Layout>
  )

  Index.getInitialProps = async function() {
    const res = await fetch('http://localhost:2019/products/')
    const data = await res.json()

    return {
      products: data
    }
  }
  
  export default Index