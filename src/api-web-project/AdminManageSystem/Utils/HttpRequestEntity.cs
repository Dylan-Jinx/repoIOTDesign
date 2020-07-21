using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace AdminManageSystem.Utils
{
    public class HttpRequestEntity
    {
		public HttpMethod Method
		{
			get;
			set;
		}

		public Encoding Encoding
		{
			get;
			set;
		}

		public string ContentType
		{
			get;
			set;
		}

		public WebHeaderCollection Headers
		{
			get;
			set;
		}

		public string Cookies
		{
			get;
			set;
		}

		public string Datas
		{
			get;
			set;
		}

		public HttpRequestEntity()
		{
			this.Headers = new WebHeaderCollection();
		}
	}
}
